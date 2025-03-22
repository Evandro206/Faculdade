import sys

class Cliente:
    def __init__(self, nome, cpf, conta):
        self.nome = nome
        self.cpf = cpf
        self.contas = [conta]

    def exibir_informacoes_cliente(self):
        ''' 
            Função: 
            -
            Explicação: 
            -
            Comentários:
        '''
        print(f"\nNome: {self.nome}")
        print(f"CPF: {self.cpf}")
        if self.contas:
            for conta in self.contas:
                conta.exibir_informacoes_conta()
        else:
            print('Este cliente não possui contas.')
    
    def adicionar_conta(self, conta):
        ''' 
            Função: 
            -
            Explicação: 
            -
            Comentários:
        '''
        self.contas.append(conta)

    @staticmethod # Permite a função ser autonoma mesmo estando na classe
    def criar_cliente():
        ''' 
            Função: 
            -
            Explicação: 
            -
            Comentários:
        '''
        nome = input('Nome do cliente: ').upper()
        cpf = int(input('Cpf do cliente: '))
        numeroConta = Conta.criar_conta()
        cliente = Cliente(nome, cpf, numeroConta)
        cliente.exibir_informacoes_cliente()
        return cliente
    
    @staticmethod # Permite a função ser autonoma mesmo estando na classe
    def excluir_cliente(clientes):
        ''' 
            Função: 
            -
            Explicação: 
            -
            Comentários:
        '''
        clientex = input('Qual o nome do Cliente que deseja excluir? ').upper()
        cliente_encontrado = next((cliente for cliente in clientes if cliente.nome == clientex), None)
        if cliente_encontrado:
            clientes.remove(cliente_encontrado)
            print(f'Cliente {clientex} excluído com sucesso!')
        else:
            print('Cliente não encontrado!')
        

class Conta:
    contador_conta = 1

    def __init__(self, numeroConta, saldo, tipoConta):
        self.numero = numeroConta
        self.saldo = saldo
        self.tipoConta = tipoConta

    def exibir_informacoes_conta(self):
        ''' 
            Função: 
            -
            Explicação: 
            -
            Comentários:
        '''
        print(f"\nConta Numero: {self.numero}")
        print(f"Saldo:  R$ {self.saldo:,.2f}")
        print(f"Tipo de Conta: {self.tipoConta}")

    @staticmethod # Permite a função ser autonoma mesmo estando na classe
    def criar_conta():
        ''' 
            Função: 
            -
            Explicação: 
            -
            Comentários:
        '''
        continuar = True
        while continuar:
            tipoConta = int(input('Qual o tipo da conta que deseja criar? \n1-Conta Corrente \n2-Conta Poupança\n'))
            if tipoConta == 1:
                tipoConta2 = 'Conta Corrente'
                continuar = False
            elif tipoConta == 2:
                tipoConta2 = 'Conta Poupança'
                continuar = False
            else:
                print('Tipo de conta inválido!')

        numeroConta = Conta.contador_conta
        Conta.contador_conta += 1
        return Conta(numeroConta, 0, tipoConta2)
    
    @staticmethod # Permite a função ser autonoma mesmo estando na classe
    def excluir_conta(clientes):
        ''' 
            Função: 
            -
            Explicação: 
            -
            Comentários:
        '''
        nome = input('Digite o nome do cliente cuja conta será excluída: ').upper()
        cliente_encontrado = next((cliente for cliente in clientes if cliente.nome == nome), None)
        if cliente_encontrado and cliente_encontrado.contas:
            numero_conta = input('Digite o número da conta a ser excluída: ')
            conta_encontrada = next((conta for conta in cliente_encontrado.contas if conta.numero == numero_conta), None)
            if conta_encontrada:
                cliente_encontrado.contas.remove(conta_encontrada)
                print('Conta excluída com sucesso!')
            else:
                print('Conta não encontrada!')
        else:
            print('Cliente ou conta não encontrados!')
    
def inicio():
    ''' 
        Função: Esse processo é responsável para proporcionar uma breve introdução para o usuário.
        -
        Explicação: Exibe no terminal menssagens(Boas Vindas ao Usuário) através de prints.
    '''
    print('+++++++++#######+++++++++')
    print('+++++++ BEM VINDO +++++++')
    print('++++++++++ AO +++++++++++')
    print('+++++++++ BANCO +++++++++')
    print('+++++++++#######+++++++++')

def continuar_programa():
    ''' 
        Função: Esse processo é responsável para solicitar do usuário se ele deseja continuar a execução do programa.
        -
        Explicação: Solicita ao usuário que responda 1 para sim e 2 para não, se a opção do usário for 1 o processo
                    executa processo main(), se a opção do usuário for 2 o processo usa o comando sys.exit(0) para encerrar
                    o programa, além disso se o usuário digitar alguma entra inválida o processo repete até que a 
                    entrada seja válida.
    '''
    try:
        continuar = int(input('Deseja continuar o programa? \n1- Sim \n2- Não\n'))
        if continuar == 1:
            main()
        elif continuar == 2:
            print('Fim da Operação!')
            sys.exit(0) # Comando para finálizar o código
        else:
            print('Opção inválida! ')
            continuar_programa()
    except ValueError:
        print('Opção inválida! ')
        continuar_programa()
        
def main():
    ''' 
        Função: Esse processo foi criado para permitir que fosse possivel executar essa sequência de códigos mais de uma vez.
        -
        Explicação: Solicita ao usuário que responda qual parte do código o mesmo deseja executar em sequência, sendo as opções 
                    disponiveis as seguintes: 1 para criar cliente, 2 para criar uma conta para um cliente, 3 para excluir um 
                    cliente, 4 para excluir uma conta x de um cliente, 5 para exibir informações de um cliente, 6 para exibir
                    informações de uma conta x de um cliente.
        -
        Comentários: sei que não é a solução mais ideal porem estou focando no funcionamento do resto do código.
    '''
    while True:
        ''' 
            Função: While responsável para repetir a execução do código até que o programa se encerre.
        '''
        try:
            ''' 
                Função: Try except para evitar que o usuário coloque um valor inválido na solicitção abaixo.
            '''
            oqueFazer = int(input('O que você deseja fazer? \n1- Criar cliente\n2- Criar conta\n3- Excluir cliente\n4- Excluir conta\n5- Exibir cliente\n6- Exibir conta\n'))
            ''' 
                Função: If's responsáveis por definir qual foi a escolha do usuário
            '''
            if oqueFazer == 1:
                ''' 
                    Função: Criar um objeto da classe Cliente.
                    -
                    Descrção: Cria se um objéto ca classe Cliente através da função criar_cliente() e o adiciona a uma 
                              lista chamada clientes, lista esta utilizada como parametro para consultas futuras.
                '''
                cliente = Cliente.criar_cliente()
                clientes.append(cliente)
                continuar_programa()
            elif oqueFazer == 2:
                ''' 
                    Função: 
                '''
                clientex = input('Qual o nome do Cliente? ').upper()
                cliente_encontrado = next((cliente for cliente in clientes if cliente.nome == clientex), None)
                if cliente_encontrado:
                    nova_conta = Conta.criar_conta()
                    cliente_encontrado.adicionar_conta(nova_conta)
                    cliente_encontrado.exibir_informacoes_cliente()
                else:
                    print('Cliente não encontrado!')
                continuar_programa()
            elif oqueFazer == 3:
                ''' 
                    Função: 
                '''
                Cliente.excluir_cliente(clientes)
                continuar_programa()
            elif oqueFazer == 4: 
                ''' 
                    Função: 
                '''
                Conta.excluir_conta(clientes)
                continuar_programa()
            elif oqueFazer == 5:
                ''' 
                    Função: 
                '''
                clientex = input('Qual o nome do Cliente? ').upper()
                cliente_encontrado = next((cliente for cliente in clientes if cliente.nome == clientex), None)
                if cliente_encontrado:
                    cliente_encontrado.exibir_informacoes_cliente()
                else:
                    print('Cliente não encontrado!')
                continuar_programa()
            elif oqueFazer == 6:  # Imcompleto
                ''' 
                    Função: 
                '''
                print('Essa parte do código ainda está sendo desenvolvida!')
                '''
                nome = input('Digite o nome do cliente cuja conta será exibida: ').upper()
                cliente_encontrado = next((cliente for cliente in clientes if cliente.nome == nome), None)
    
                if cliente_encontrado:
                    print(f'Cliente encontrado: {cliente_encontrado.nome}')
                    if cliente_encontrado.contas:
                        numero_conta = input('Digite o número da conta a ser exibida: ')
                        conta_encontrada = next((conta for conta in cliente_encontrado.contas if conta.numero == numero_conta), None)
            
                        if conta_encontrada:
                            print(f'Conta encontrada: {conta_encontrada.numero}')
                            conta_encontrada.exibir_informacoes_conta()
                        else:
                            print('Conta não encontrada!')
                    else:
                        print('O cliente não possui contas!')
                else:
                    print('Cliente não encontrado!')
                '''
                continuar_programa()
            else:
                ''' 
                    Função: 
                '''
                print('Opção inválida!')
                continuar_programa()
        except ValueError:
            print('Por favor, insira um número válido.')

'''
  Função: Esse código é o inicio programa.
'''           
clientes = []
inicio()
main()
