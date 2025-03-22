# Programa01
def soma_numeros():
    print("Soma dos numeros é:", int(input('Numero 1:')) + int(input('Numero 2:')))
soma_numeros()

# Programa02
def soma_numeros():
    global Soma
    Soma = Num1 + Num2

Num1 = int(input("Numero 1:")) 
Num2 = int(input("Numero 2:"))
print(f"Soma dos numeros é: {soma_numeros()}")

# Programa03
Num1 = int(input("Numero 1:")) 
Num2 = int(input("Numero 2:"))

if Num1 > Num2:
    print(f"O numero {Num1} é maior!")
elif Num2 > Num1:
    print(f"O numero {Num2} é maior!")
else:
    print(f"Os numeros são iguais!")