def fileDuplo(kg):
    if kg <= 5:
        preço = kg * (4.9)
    else: 
        preço = kg * (5.8)
    return preço

def alcatra(kg):
    if kg <= 5:
        preço = kg * (5.9)
    else: 
        preço = kg * (6.8)
    return preço

def picanha(kg):
    if kg <= 5:
        preço = kg * (6.9)
    else: 
        preço = kg * (7.8)
    return preço

print("                      Até 5 Kg           Acima de 5 Kg \n File Duplo      R$ 4,90 por Kg          R$ 5,80 por Kg \n Alcatra         R$ 5,90 por Kg          R$ 6,80 por Kg \n Picanha         R$ 6,90 por Kg          R$ 7,80 por Kg")
carne = input("Qual tipo de carne você quer: ")
peso = float(input("Quantos quilos: "))
f_pagamento = input("Qual a forma de pagamento: \n - Tabajara \n - Outro \n")
carne = carne.upper()
f_pagamento = f_pagamento.upper()

if carne == 'FILE DUPLO':
    preçofinal = fileDuplo(peso)
elif carne == 'ALCATRA':
    preçofinal = alcatra(peso)
elif carne == 'PICANHA':
    preçofinal = picanha(peso)

if f_pagamento == 'TABAJARA':
    desc = preçofinal * (0.05)
    preçofinal = preçofinal * (0.95)
else:
    desc = 0

print(f"Carne: {carne} Peso: {round(peso,1)}kg Preço: {round(preçofinal,2)}R$ Desconto: {round(desc,2)}R$")