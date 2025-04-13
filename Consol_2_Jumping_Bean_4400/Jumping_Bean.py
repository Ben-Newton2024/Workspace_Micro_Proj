import pygame
import random
import sys

WIDTH, HEIGHT = 500, 300

pygame.init()

window = pygame.display.set_mode((WIDTH, HEIGHT))
clock = pygame.time.Clock()


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


def move(rect, x, y):
    rect.x += x
    rect.y += y
    if rect.x >= WIDTH:
        rect.x = 0
    if rect.x < -rect.w:
        rect.x = WIDTH
    if x != 0 and rect.y + rect.h == HEIGHT:
        dust.append(Dust(rect.midbottom))


def grav(rect, g_force=6):
    rect.y += g_force
    if rect.y + rect.h >= HEIGHT:
        rect.y = HEIGHT - rect.h
        dust.append(Dust(rect.midbottom))


player = pygame.Rect(30, 30, 32, 32)
player_speed = 5
dust = []
x, y = 0, 0

while True:
    clock.tick(30)

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            exit()
        if event.type == pygame.MOUSEBUTTONDOWN:
            if pygame.mouse.get_pressed()[0]:
                d = Dust(pygame.mouse.get_pos())
                dust.append(d)
    if event.type == pygame.KEYDOWN:
        if event.key == pygame.K_LEFT:
            x = -player_speed
        if event.key == pygame.K_RIGHT:
            x = player_speed
        if event.key == pygame.K_UP:
            y = -20
    if event.type == pygame.KEYUP:
        if event.key == pygame.K_LEFT:
            X = 0
        if event.key == pygame.K_RIGHT:
            X = 0
        if event.key == pygame.K_UP:
            y = 0

    window.fill((0, 0, 0))
    pygame.draw.rect(window, (255, 0, 0), player)

    move(player, x, y)

    if player.y + player.h < HEIGHT:
        grav(player)

    for i in range(len(dust)):
        if len(dust[i].particles) > 0:
            dust[i].draw(window)
            dust[i].update()
    pygame.display.flip()

# Version 2 of this consolidation. done in lesson, involved loading images, and a background to the game.
# however not having the images, I decided to roll back to this version, having a basic moving character
# to play around with whenever.
