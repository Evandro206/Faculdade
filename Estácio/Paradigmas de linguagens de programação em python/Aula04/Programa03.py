import math

def delta(a, b, c):
     delta = (b ** 2) - (4 * a * c)
     return delta

def x1(delta, a, b):
    x1 = ((-b) + math.sqrt(delta))/ (2 * a)
    return x1

def x2(delta, a, b):
     x2 = ((-b) - math.sqrt(delta))/ (2 * a)
     return x2

a = float(input("Digite A: "))
b = float(input("Digite B: "))
c = float(input("Digite C: "))

if a <= 0:
        print("A digitado é inválido. ")
while a <= 0:
    a = float(input("Digite A nomavamente:"))
    if a <= 0:
        print("A digitado é inválido. ")

vdelta = delta(a, b, c)
if vdelta < 0:
     print("Delta não possui raizes reais.")
elif vdelta == 0:
     vx1 = x1(vdelta , a, b)
     print(f"Delta: {delta} X: {vx1}")
elif vdelta > 0:
    vx1 = x1(vdelta , a, b)
    vx2 = x2(vdelta , a, b)
    print(f"Delta: {vdelta} X1: {vx1} X2:{vx2}")