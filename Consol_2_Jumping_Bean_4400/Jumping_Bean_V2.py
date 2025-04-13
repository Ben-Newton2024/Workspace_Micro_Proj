import pygame
import random
import time

WIDTH, HEIGHT = 500, 300

pygame.init()

window = pygame.display.set_mode((WIDTH, HEIGHT))

# TODO - NEED MORE IMAGES, since this recopied work from a virtual Machine, couldnt get it of work system


bg = pygame.image.load('images/bg.jpg')
char = pygame.image.load('images/standing.png')

# walking right animation in list to loop
walkRight = [pygame.image.load('images/R1.png')]
walkLeft = [pygame.image.load('images/L1.png')]

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

    def draw(self, window):
        pygame.draw.circle(window, (255, 255, 255), (int(self.x), int(self.y)), self.rad)

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

    def draw(self, window):
        for i in self.particles:
            i.draw(window)

    def update(self):
        for i in self.particles:
            i.update()
            self.particles = [particle for particle in self.particles if particle.rad > 0]


class Player():
    def redrawWin(self):
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
        pygame.display.update()
        for i in range(len(dust)):
            if len(dust[i].particles) > 0:
                dust[i].draw(window)
                dust[i].update()

    def movement(self):
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
            walkCount = 0
        if not (isJump):
            if keys[pygame.K_UP]:
                isJump = True
                left = False
                right = False
                walkCount = 0
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
            run = False
            pygame.quit()
            exit()
        if event.type == pygame.MOUSEBUTTONDOWN:
            if pygame.mouse.get_pressed()[0]:
                d = Dust(pygame.mouse.get_pos())
                dust.append(d)


while run == True:
    pygame.time.delay(25)

    events()
    Player.movement()
    Player.redrawWin()

pygame.quit()
