def func1(x):
    return x + 1
def func2(x):
    return x + 2
escolha =  input("Escolha um opção de função: 1 ou 2\n")
if escolha == "1":
    s = func1(10)
else:
    s = func2(10)
print(s)