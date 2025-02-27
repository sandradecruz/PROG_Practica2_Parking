# 2ª PRACTICA DE PROGRAMACIÓN: Parking
## Objetivo 📍
<p>Desarrolla un programa Java que simule la máquina de un parking 
de vehículos.</p>

## Operativa ⚙
<p>El parking tiene una capacidad para 60 vehículos, distribuidos en 3 plantas de 20 plazas cada una.</p>

<p>Cuando un vehículo llega al parking, la máquina expide un ticket, suponiendo que el parking no está completo. En caso contrario, no se permitirá la entrada de más vehículos hasta que haya plazas disponibles.</p>

<p>Para sacar el vehículo del parking, previamente se abonará la cantidad de dinero correspondiente al tiempo estacionado. El precio por minuto de estacionamiento es de 0,50€, y el tiempo de estacionamiento se computa por minutos completos, de tal forma que 1 min. 01 seg. se computa como 2 min.</p>

<p>La máquina admite monedas de los siguientes tipos: 1€ 2€ 0,50€ 0,20€ 0,10€ y 0,05 €. 
También admite billetes de 5€, 10€ y 20€. Si se introduce una cantidad de dinero superior a 
la cantidad a pagar, la máquina dará la vuelta en el tipo de moneda más grande posible.</p>

## Diseño 🎨
<p>Implementa las clases necesarias para crear un diseño orientado a objetos de acuerdo 
con las siguientes indicaciones:</p>
<ul>
  <li>Una clase PRINCIPAL será la encargada de crear una instancia de la MAQUINA del parking, pasándola el precio/minuto como un double. </li>
  <li>Una vez creada la MAQUINA se creará el TERMINAL, a través del cual el usuario  podrá utilizar la máquina, y se conectará a la misma. Es decir, a través del TERMINAL se permitirá realizar las acciones de estacionar y sacar el vehículo del parking.</li>
  <li>El TICKET de entrada que se genera al estacionar un vehículo en el parking contendrá la siguiente información: un identificador único, matrícula del coche, fecha/hora de entrada y UBICACIÓN (planta/plaza) asignada. </li>
</ul>

<p>La MAQUINA incluirá los siguientes componentes:</p>
<ul>
  <li>El TERMINAL, a través del cual se podrá controlar el funcionamiento de la máquina.</li>
  <li>Un DEPOSITO que llevará el control de la cantidad de monedas y billetes de cada tipo disponibles en la máquina. Inicialmente tendrá 100 monedas y 100 billetes de cada tipo.</li>
  <li>Una lista (ArrayList) con los tickets generados.</li>
  <li>El plano de plazas del parking, modelado a través de una matriz, a través del cual se podrá controlar la ubicación de los vehículos y los sitios libres.
</li>
</ul>

## Interfaz 🖥
<p>El usuario utilizará la máquina a través del TERMINAL, dándole opción de estacionar y retirarun vehículo.</p>
<p>Realiza un sencillo diseño gráfico (Swing) del TERMINAL, que permita realizar las dos 
operaciones.</p>
