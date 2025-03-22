from datetime import datetime

class Cliente:
    def __init__(self, numero, cpf, nome, data):
        self.numero = numero
        self.cpf = cpf
        self.nome = nome
        self.data = data
    def __str__(self):
        return f"Cliente(nome={self.nome}, cliente={self.numero}, cpf={self.cpf}, data de nascimento={self.data})"
    def excluicliente(self):
        a = Conta.findcontacpf(self.numero)
        for i, b in enumerate(a):
            Conta.excluirconta(contas[b])
        self.numero = None
        self.cpf = None
        self.nome = None
        self.data = None
        print("Cliente excluido com sucesso !")
        return
    
    @staticmethod
    def exibircliente(a):
        print("O nome do(a) cliente é:",a.nome)
        print("O numero do(a) cliente é:",a.numero)
        print("A data de nascimento do(a) cliente é:",a.data)
        a = Conta.findcontacpf(a.numero)
        print("Possui a(s) seguinte(s) conta(s):", a )
        return
    @staticmethod
    def criarcliente():
        global numerocliente
        global clientes
        while True:
            cpf = input("Digite seu CPF sem espaços nem pontos ou traços: ")
            i = 2
            if len(cpf) != 11:
                true = False
            else:
                soma = sum(int(cpf[i]) * (10 - i) for i in range(9))
                primeiro_digito = (soma * 10 % 11) % 10
                soma = sum(int(cpf[i]) * (11 - i) for i in range(10))
                segundo_digito = (soma * 10 % 11) % 10
                true = cpf[-2:] == f"{primeiro_digito}{segundo_digito}"
            i = Cliente.findcliente(cpf)
            if i != "a":
                print("Cliente com esse CPF ja existente!")  
                i = input("Deseja voltar ao menu inicial?? 1 - sim 2 - não")
            else:             
                if true == False:
                    print("CPF invalido ou digitado de forma incorreta!")  
                    i = input("Deseja voltar ao menu inicial?? 1 - sim 2 - não")
                else:
                    break
            if i == 1:
                return None
        while True:
            try:
                data = input("Digite sua data de nascimento da seguinte maneira (dd/mm/yyyy): ")
                datavalida = datetime.strptime(data, "%d/%m/%Y")
                break
            except:
                print("A data foi digitada de maneira incorreta, ou apresenta caracteres invalidos.\n Tente novamente!")
        nome = input("Digite seu nome completo: ").lower()
        clientedef = Cliente(numerocliente, cpf, nome, datavalida)
        print("Vamos criar uma conta inicial: ")
        clientes.append(clientedef)
        Conta.criaconta(clientedef)
        numerocliente = numerocliente + 1
        return clientedef
    @staticmethod
    def findcliente(procurado):
        for i, cliente in enumerate(clientes):
            if procurado == cliente.cpf:
                return i
        return "a"

class Conta:
    def __init__(self, numero, cliente, tipo, saldo=0):
        self.numero = numero
        self.cliente = cliente
        self.tipo = tipo
        self.saldo = saldo
    def __str__(self):
        return f"Conta(numero={self.numero}, cliente={self.cliente}, tipo={self.tipo}, saldo={self.saldo})"
    def excluirconta(self):
        self.numero = None
        self.cliente = None
        self.tipo = None
        self.saldo = None
        print("Conta excluida com sucesso !")
        return
    def depositar(self):
        deposito = int(input("Deseja depositar quanto dinheiro?"))
        self.saldo = self.saldo + deposito
        Conta.exibirsaldo(self)
        return
    def exibirsaldo(self):
        print("Seu saldo atual é: R$", self.saldo)

    @staticmethod
    def criaconta(clientedef):
        global numeroconta
        global contas
        tipo_de_conta = ["corrente", "poupanca"]
        while True:
            tipo = input("Digite o tipo de conta que deseja (corrente/poupanca):").lower()
            if tipo in tipo_de_conta:
                break
            else:
                print(tipo, 'erro')
                print("Tipo de conta digitado incorretamente, tente novamente")
        if tipo == 'corrente':
            data = datetime.now()
            if (data.month, data.day) < (clientedef.data.month, clientedef.data.day):
                aniversario = 1
            else:
                aniversario = 0
            idade = data.year - clientedef.data.year - aniversario
            conta = ContaCorrente(tipo, numeroconta, clientedef.numero, idade)
        else:
            conta = ContaPoupanca(tipo, numeroconta, clientedef.numero)
        contas.append(conta)
        numeroconta += 1
        return
    @staticmethod
    def findconta(procurado): 
        for i, contax in enumerate(contas):
            if procurado == contax.numero:
                return i
        return -1
    @staticmethod
    def findcontacpf(procurado):
        a = []
        for i, contax in enumerate(contas):
            if procurado == contax.cliente:                 
                a.append(i)
        return a                                         
    @staticmethod
    def exibirconta(conta):
        print("A conta é uma conta do tipo: Conta", conta.tipo )        
        print("O numero da conta é:", conta.numero )        
        if conta.tipo == "corrente":
            print("O Saldo atual da conta é", conta.saldo )
            print("O Limite de Cheque especial é: R$", conta.limite_cheque_especial)
        if conta.tipo == "poupanca":
            ContaPoupanca.calcular_juros(conta)
        return
class ContaCorrente(Conta):
    def __init__(self, tipo, numero, cliente, idade, saldo=0):
        super().__init__(numero, cliente, tipo, saldo)
        self.limite_cheque_especial = idade * 50
    def sacar(self):
        Conta.exibirsaldo(self)
        print("Você pode sacar um total de R$", self.saldo + self.limite_cheque_especial,"( R$",self.saldo," de Saldo + R$",self.limite_cheque_especial,"de cheque especial)")
        saque = int(input("Quanto deseja sacar? "))
        if saque > 0:
            if saque > self.saldo + self.limite_cheque_especial:
                print("Saldo insuficiente, incluindo cheque especial.")
            else:
                self.saldo -= saque
                print(f"Saque de {saque} realizado com sucesso. Saldo atual: {self.saldo}")
        else:
            print("Valor digitado invalido para saque!")
        return    
class ContaPoupanca(Conta):
    def __init__(self, tipo, numero, cliente, saldo=0, taxa_juros=0.01):
        super().__init__(numero, cliente, tipo, saldo)
        self.taxa_juros = taxa_juros
    def calcular_juros(self):
        juros = self.saldo * self.taxa_juros
        self.saldo += juros
        print(f"Juros de {juros} aplicados. Saldo atual: {self.saldo}")
    def sacar(self):
        Conta.exibirsaldo(self)
        print("Você pode sacar um total de R$", self.saldo)
        saque = int(input("Quanto deseja sacar? "))
        if saque > 0:
            if saque > self.saldo:
                print("Saldo insuficiente")
            else:
                self.saldo = self.saldo - saque
                print(f"Saque de {saque} realizado com sucesso. Saldo atual: {self.saldo}")
        else:
            print("Valor digitado invalido para saque!")
        return

def inicio():
    print('+++++++++#######+++++++++')
    print('+++++++ BEM VINDO +++++++')
    print('++++++++++ AO +++++++++++')
    print('+++++++++ BANCO +++++++++')
    print('+++++++++#######+++++++++')
    return

def encontra():
    while True:
        procura = input("Digite o cpf do cliente: ")
        i = Cliente.findcliente(procura)
        if i == "a":
            a = input("Cliente não encontrado, deseja tentar novamente? 1 - sim 2 - não")
            if a == "2":
                return -1
        else:
            return i

def encontraconta():
    while True:
        procura = int(input("Digite o número da conta: "))
        i = Conta.findconta(procura)
        if i == -1 :
            a = input("Conta não encontrada, deseja tentar novamente? 1 - sim 2 - não")
            if a == "2":
                return -1
        else:
            return i
        
numerocliente = 1
numeroconta = 1
clientes = [Cliente(0,0,0,0)]
contas = [ContaCorrente(0,0,0,0,0)]

while True:
    i = 0
    inicio()
    try:
        oqueFazer = int(input('\nO que você deseja fazer? \n1- Criar cliente\n2- Criar conta\n3- Excluir cliente\n4- Excluir conta \n5- Exibir cliente\n6- Exibir conta\n7- Depositar\n8- Sacar_INCOMPLETO\n9- Encerrar aplicação\n'))
        if oqueFazer == 1:
            Cliente.criarcliente()
        elif oqueFazer == 2:
            i = encontra()
            if i == -1:
                print("Cliente não encontrado")
            else:
                Conta.criaconta(clientes[i])
        elif oqueFazer == 3:            
            i = encontra()
            if i == -1:
                print("Cliente não encontrado")
            else:
                Cliente.excluicliente(clientes[i])
        elif oqueFazer == 4:            
            i = encontraconta()
            if i != -1:
                Conta.excluirconta(contas[i])
        elif oqueFazer == 5:
            i = encontra()
            if i == -1:
                print("Cliente não encontrado")
            else:
                Cliente.exibircliente(clientes[i])
        elif oqueFazer == 6:
            i = encontraconta()
            if i != -1:
                Conta.exibirconta(contas[i])                
        elif oqueFazer == 7:          
            i = encontraconta()
            if i != -1:
                Conta.depositar(contas[i])
        elif oqueFazer == 8:          
            i = encontraconta()
            if i != -1:
                if contas[i].tipo == "corrente":
                    ContaCorrente.sacar(contas[i])    
                else:
                    ContaPoupanca.sacar(contas[i])                  
        elif oqueFazer == 9:
            break
    except ValueError:
        print('Por favor, insira um número válido.')