@todo
Feature: PetStore API

  @crearOrden
  Scenario Outline: Creacion de order
    Given la url base del servicio es "https://petstore.swagger.io/v2"
    And la ruta del enpoint para crear una orden es "/store/order"
    When creacion de una nueva orden con los siguientes datos "<id>", "<petId>","<quantity>","<shipDate>","<status>" , "<complete>"
    Then valido que el codigo de respuesta sea 200
    And el body de la respuesta no es nulo
    And el body de la respuesta contiene los siguientes datos "<id>", "<petId>","<quantity>","<shipDate>","<status>" , "<complete>"
    Examples:
      | id | petId | quantity | shipDate                     | status | complete |
      | 3  | 1     | 0        | 2024-12-17T00:00:00.000+0000 | placed | true     |
      | 4  | 6     | 1        | 2024-12-18T17:03:17.861+0000 | placed | false    |
      | 5  | 10    | 0        | 2024-12-14T00:00:00.000+0000 | placed | false    |
      | 10 | 8     | 0        | 2024-12-06T17:05:36.861+0000 | placed | true     |


  @consultarOrden
  Scenario Outline: Consulta de order
    Given la url base del servicio es "https://petstore.swagger.io/v2"
    And la ruta del enpoint para consultar una orden es "/store/order/<orderId>"
    When se consulta el pedido con ID "<orderId>"
    Then valido que el codigo de respuesta sea 200
    And el body de la respuesta no es nulo
    And el body de la respuesta contiene el Id de la orden "<orderId>"
    Examples:
      | orderId |
      | 3       |
      | 4       |
      | 5       |
      | 10      |

