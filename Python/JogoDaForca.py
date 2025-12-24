import random
import os

def limpar():
    os.system("cls" if os.name == "nt" else "clear")

#escolha do modo
print("1 - Solo")
print("2 - Dupla")
modo = input("Escolha o modo: ")

#definição da palavra
if modo == "1":
    palavras = ["python", "linux", "codigo", "terminal", "logica"]
    palavra = random.choice(palavras)
else:
    palavra = input("Jogador 1, digite a palavra: ").lower()
    limpar()

letras_usadas = []
vidas = 6

while vidas > 0:
    exibicao = ""

    for letra in palavra:
        exibicao += letra if letra in letras_usadas else "_"

    print("\nPalavra:", exibicao)
    print("Vidas:", vidas)

    if "_" not in exibicao:
        print("Você ganhou :)")
        break

    chute = input("Letra: ").lower()

    if chute in letras_usadas or len(chute) != 1 or not chute.isalpha():
        print("Entrada inválida.")
        continue

    letras_usadas.append(chute)

    if chute not in palavra:
        vidas -= 1
        print("Errou.")

if vidas == 0:
    print("Você perdeu :(")
    print("A palavra era:", palavra)

