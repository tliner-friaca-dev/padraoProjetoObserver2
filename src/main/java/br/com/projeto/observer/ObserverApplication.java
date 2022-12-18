package br.com.projeto.observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.projeto.observer.model.FichaAlteracaoPeso;
import br.com.projeto.observer.notificador.Notificador;
import br.com.projeto.observer.notificador.NotificadorAlteracaoPeso;
import br.com.projeto.observer.ouvintes.AcademiaOuvinte;
import br.com.projeto.observer.ouvintes.NutricionistaOuvinte;
import br.com.projeto.observer.ouvintes.OuvinteInt;
import br.com.projeto.observer.ouvintes.PersonalTrainerOuvinte;
import br.com.projeto.observer.repository.FichaAlteracaoPesoRepository;

@SpringBootApplication
public class ObserverApplication {

	static Notificador notificador = new NotificadorAlteracaoPeso();
	
	static OuvinteInt academiaOuvinte = new AcademiaOuvinte(notificador);
	static OuvinteInt nutricionistaOuvinte = new NutricionistaOuvinte(notificador);
	static OuvinteInt personalTrainerOuvinte = new PersonalTrainerOuvinte(notificador);

	public static void main(String[] args) {
		SpringApplication.run(ObserverApplication.class, args);

		System.out.println("\n----------------------");
		System.out.println("ENTROU NA APLICAÇÃO!!!");
		System.out.println("----------------------\n\n");

		FichaAlteracaoPesoRepository fichaAlteracaoPesoRepository = new FichaAlteracaoPesoRepository();


		List<FichaAlteracaoPeso> fichasAlteracaoPeso = fichaAlteracaoPesoRepository.buscarFichaAlteracaoPeso();

		notificador.novosAlunosComAlteracaoDePeso(fichasAlteracaoPeso);

		// Legenda para testes
		System.out.println("\n--------Legenda-------");
		System.out.println("1 - Ouvintes: \n  - Academia \n  - Nutricionista \n  - Personal Trainer\n");
		System.out.println("2 - Ouvintes: \n  - Academia \n  - Nutricionista \n");
		System.out.println("3 - Ouvintes: \n  - Academia \n  - PersonalTrainer\n");
		System.out.println("4 - Ouvintes: \n  - Nutricionista \n  - Personal Trainer\n");

		System.out.println("5 - Ouvintes: \n  - Academia\n");
		System.out.println("6 - Ouvintes: \n  - Nutricionista\n");
		System.out.println("7 - Ouvintes: \n  - Personal Trainer");
		System.out.println("----------------------\n\n");

		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {

				int legenda = getRandomNumberUsingInts(1,7);
				List<OuvinteInt> ouvintesIntAdd =  retornaOuvinteInt(legenda);

				System.out.printf("Legenda escolhida: %s\n", legenda);

				for (OuvinteInt ouvinteIntAdd : ouvintesIntAdd) {
					notificador.removerOuvinte(ouvinteIntAdd);
				}

				notificador.notificarOuvintes();

				for (OuvinteInt ouvinteIntAdd : ouvintesIntAdd) {
					notificador.registrarOuvinte(ouvinteIntAdd);
				}

				System.out.println("");
			}
			
		};

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 1000L, 10000L);
		
	}

	public static int getRandomNumberUsingInts(int min, int max) {
		Random random = new Random();
		return random.ints(min, max)
		  .findFirst()
		  .getAsInt();
	}

	public static List<OuvinteInt> retornaOuvinteInt(int legenda) {
		
		List<OuvinteInt> ouvintesInt = new ArrayList<OuvinteInt>();

		switch (legenda) {
			case 1:
				return ouvintesInt;
			case 2:
				ouvintesInt = Arrays.asList(personalTrainerOuvinte);
				return ouvintesInt;
			case 3:
				ouvintesInt = Arrays.asList(nutricionistaOuvinte);
				return ouvintesInt;
			case 4:
				ouvintesInt = Arrays.asList(academiaOuvinte);
				return ouvintesInt;
			case 5:
				ouvintesInt = Arrays.asList(nutricionistaOuvinte, personalTrainerOuvinte);
				return ouvintesInt;
			case 6:
				ouvintesInt = Arrays.asList(academiaOuvinte, personalTrainerOuvinte);
				return ouvintesInt;
			case 7:
				ouvintesInt = Arrays.asList(academiaOuvinte, nutricionistaOuvinte);
				return ouvintesInt;
			default:
				return ouvintesInt;
		}

	}

}
