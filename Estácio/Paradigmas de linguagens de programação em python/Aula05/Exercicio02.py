def func1():
    global x
    x = 30
    X = 10
    print(f"Função func1 - x = {x}")
    print(f"Função func1 - X = {X}")

def func2():
    X = 20
    print(f"Função func2 - x = {x}")
    print(f"Função func2 - X = {X}")

x = 5
func1()
print(f"Programa principal após func1() - x = {x}")
func2()
print(f"Programa principal após func2() - x = {x}")