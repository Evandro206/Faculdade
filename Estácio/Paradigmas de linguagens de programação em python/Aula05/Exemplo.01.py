import tkinter as tk

def criar_janela():
    janela = tk.Tk()
    janela.title("Minha Aplicação")

    label = tk.Label(janela, text="Digite algo:")
    label.pack()

    entrada = tk.Entry(janela)
    entrada.pack()

    botao = tk.Button(janela, text="Clique aqui", command=lambda: print(entrada.get()))
    botao.pack()

    janela.mainloop()

criar_janela()