## Doarte-API
###

> O presente projeto é a API para o projeto doarte. Autoria: Lucas Porto

Até o momento foi implementado o CRUD para os registros de doadores:

- Implementado método post para cadastro de users donators.
- Implementado método PUT para a atualização de determinados campos dos users
- Implementado método GET para que seja retornado ao FRONT os users ativos
- Implementado método DELETE para realizar a deleção lógica dos users. Não foi implementado método para a deleção física dos users.

Json for POST:

<details><summary>Mais...</summary>

	{
		"nome": "Lucas Rodrigues Porto",
		"email": "lucasteste@teste.teste",
		"telefone": "629999999",
		"nascimento": "1989-08-09",
		"endereco": {
			"cep": "74610190",
			"rua": "Travessa Fernando Hernandes Gentil",
			"bairro": "Tancredo Neves",
			"cidade": "Salvador",
			"uf": "BA",
			"numero": "945",
			"complemento": "Complemento para teste Lucas"
	}
}

</details>
