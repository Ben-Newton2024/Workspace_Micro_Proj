import pygame
import random

WIDTH, HEIGHT = 600, 480

pygame.init()

window = pygame.display.set_mode((WIDTH, HEIGHT))

# todo - fix left animation, get particles to draw infront of background.


bg = pygame.image.load('images/bg.jpg')
char = pygame.image.load('images/standing.png')

# walking right animation in list to loop
walkRight = [pygame.image.load('images/R1.png'),
             pygame.image.load('images/R2.png'),
             pygame.image.load('images/R3.png'),
             pygame.image.load('images/R4.png'),
             pygame.image.load('images/R5.png'),
             pygame.image.load('images/R6.png'),
             pygame.image.load('images/R7.png'),
             pygame.image.load('images/R8.png'),
             pygame.image.load('images/R9.png')]

walkLeft = [pygame.image.load('images/L1E.png'),
            pygame.image.load('images/L2E.png'),
            pygame.image.load('images/L3E.png'),
            pygame.image.load('images/L4E.png'),
            pygame.image.load('images/L5E.png'),
            pygame.image.load('images/L6E.png'),
            pygame.image.load('images/L7E.png'),
            pygame.image.load('images/L8E.png'),
            pygame.image.load('images/L9E.png')]

dust = []
player = pygame.Rect(30, 30, 32, 32)
left = False
right = False
walkCount = 0

x = 50
y = 420

width = 40
height = 60
velocity = 5

isJump = False
jumpCount = 10

run = True


class Particle:
    def __init__(self, pos):
        self.x, self.y = pos
        self.vx, self.vy = random.randint(-2, 2), random.randint(-10, 0) * .1
        self.rad = 5

    def draw(self, win):
        pygame.draw.circle(win, (255, 255, 255), (int(self.x), int(self.y)), self.rad)

    def update(self):
        self.x += self.vx
        self.y += self.vy
        if random.randint(0, 100) < 40:
            self.rad -= 1


class Dust:
    def __init__(self, pos):
        self.pos = pos
        self.particles = []
        for i in range(50):
            self.particles.append(Particle(pos))

    def draw(self, win):
        for i in self.particles:
            i.draw(win)

    def update(self):
        for i in self.particles:
            i.update()
            self.particles = [particle for particle in self.particles if particle.rad > 0]


def redraw_window():
    global walkCount
    window.blit(bg, (0, 0,))

    if walkCount + 1 >= 27:
        walkCount = 0
    if left:
        window.blit(walkLeft[walkCount // 3], (x, y))
        walkCount += 1
    if right:
        window.blit(walkRight[walkCount // 3], (x, y))
        walkCount += 1
    else:
        window.blit(char, (x, y))
    for i in range(len(dust)):
        if len(dust[i].particles) > 0:
            dust[i].draw(window)
            dust[i].update()
    pygame.display.update()


def movement():
    global x, y, width, height, isJump, jumpCount, left, right

    keys = pygame.key.get_pressed()
    if keys[pygame.K_LEFT] and x > velocity:
        left = True
        right = False
        x -= velocity
        dust.append(Dust((x + width, y + height)))
    if keys[pygame.K_RIGHT] and x < WIDTH - width - velocity:
        left = False
        right = True
        x += velocity
        dust.append(Dust((x + width / 2, y + height)))
    else:
        right = False
        left = False

    if not isJump:
        if keys[pygame.K_UP]:
            isJump = True
            left = False
            right = False
    else:
        if jumpCount >= -10:
            neg = 1
            if jumpCount < 0:
                neg = -1
            y -= (jumpCount ** 2) * .5 * neg
            jumpCount -= 1
        else:
            isJump = False
            jumpCount = 10


def events():
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            exit()
        if event.type == pygame.MOUSEBUTTONDOWN:
            if pygame.mouse.get_pressed()[0]:
                d = Dust(pygame.mouse.get_pos())
                dust.append(d)


while run:
    pygame.time.delay(25)

    events()
    movement()
    redraw_window()

pygame.quit()
