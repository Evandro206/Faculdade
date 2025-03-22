import random 
aleatorio01 = 0
aleatorio02 = 1
while aleatorio01 != aleatorio02:
    aleatorio02 = aleatorio01
    aleatorio01 = random.random()
    print(aleatorio01)
    print(random.uniform(20, 50))
