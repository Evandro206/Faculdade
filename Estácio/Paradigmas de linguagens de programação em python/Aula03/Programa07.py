while True:
    nota = int(input("Digite uma nota entre 0 e 10? "))
    if(nota in range(0,11)):
        break
    else:
        print("Nota inválida!")
print(f"A nota é: {nota}")