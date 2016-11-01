# 2016_AIAD_T05_1

#T05: Exploração de Marte

##Objetivo
Implementar um Sistema Multi-Agente para simulação de um cenário de extracção de minérios em Marte.

##Descrição
Um conjunto de agentes tem a tarefa de explorar o o planeta Marte em busca de minérios, e de transportar a maior quantidade possível para a base. Há três tipos de agentes. O agente spotter tem o papel de procurar fontes de minérios e inspeccioná-las para determinar se podem ser exploradas. Um agente producer é chamado a uma fonte de minério por um spotter para extrair o máximo de minério possível nessa fonte. Quando termina, o producer procura alocar um ou mais agentes transporter para carregarem o minério obtido para a base.

Para facilitar a procura, todos os agentes podem localizar fontes de minérios e enviar a sua localização para os spotter, que os analisarão. A escolha do producer por parte do spotter deve seguir um protocolo de negociação, a definir. A alocação de transporters a uma determinada fonte deve também seguir um protocolo de negociação, iniciado pelo producer. Essa alocação deve ter em conta a quantidade de minério a transportar, de modo a determinar mais corretamente o número de transporters necessários.

Devem ser exploradas e simuladas diferentes situações, como por exemplo as capacidades de comunicação dos agentes, a sua autonomia, e diferentes estratégias de alocação de outros agentes para as diferentes tarefas.

##Material
Repast+SAJaS
