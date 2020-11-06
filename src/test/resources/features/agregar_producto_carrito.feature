@driver:chrome
Feature: Realizar compra de Articulo

  Background: Iniciar sesion usuario registrado
    Given el ingreso a la tienda virtual
    When ingreso usuario y clave
    Then acceso con usuario registrado


  Scenario: Agregar dos articulos de carro de compras
    Given ingreso a sesion women
    When se selecciona un articulo
    Then se agregan al carrro de compras