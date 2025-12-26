alunos = []

while True:
    nome = input("Nome do aluno (ou 'sair' para finalizar): ")
    if nome.lower() == "sair":
        break

    nota = float(input("Nota do aluno: "))

    status = "Aprovado" if nota >= 7.0 else "Reprovado"

    alunos.append({
        "nome": nome,
        "nota": nota,
        "status": status
    })

print("\n=== Resultado Final ===")
for aluno in alunos:
    print(f"{aluno['nome']} - Nota: {aluno['nota']} - {aluno['status']}")

