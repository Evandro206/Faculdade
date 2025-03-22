while True:
    try:
        nr = int(input('Digite um numero ou -1 para encerar: '))
        if nr == -1:
            break
        s = nr * 3
        print(s)
        q =  12/s
    except ValueError:
        print('Digite um numero valido!')
    except ZeroDivisionError:
        print("Não da pra dividir por zero!")
    else:
        print(q)
    finally:
        print("Obrigado por usar o programa! ")
