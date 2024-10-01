Feature: Product - Store

  @validLogin @validCategory
  Scenario Outline: Validación del precio de un producto
    Given estoy en la página de la tienda My Store
    And me logueo con mi usuario<username> y clave<password>
    When navego a la categoria<category> y subcategoria<subcategory>
    And agrego <quantity> unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito

    Examples:
      | username             | password    | category | subcategory | quantity |
      | yanirakim4@gmail.com | Negrinka21. | Clothes  | Men         | 2        |
      | yanirakim@gmai.com   | wrongPwd    | Clothes  | Men         | 2        |
      | yanirakim4@gmail.com | Negrinka21. | Autos    | Men         | 2        |