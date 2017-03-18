print('Hola desde archivo JS');

function calcular(numero1, numero2) {
	return numero1 + numero2;
}

var hiloImpl = {
		run : function() {
			for (var i = 0; i < 20; i++) {
				print("imprimiendo " + i);
			}
		}
	}