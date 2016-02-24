package aspectos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import modelo.service.GestionCajero;

@Component
//@Scope(scopeName="prototype")
@Aspect
public class ControlBanco {
	int ing, ext;
	
	@Before("execution(* modelo.service.GestionCajero.ingresar(..))")
	public void logIngreso(JoinPoint jp){
		ing++;
		System.out.println("Ingresos: "+ing);
	}
	@Before("execution(* modelo.service.GestionCajero.extraer(..))")
	public void logExtraer(JoinPoint jp){
		ext++;
		System.out.println("Extracciones: "+ext);
	}
	@Around("execution(* modelo.service.GestionCajero.extraer(..))")
	public void logControl(ProceedingJoinPoint pjp) throws Throwable{
		GestionCajero gcajero=(GestionCajero)pjp.getTarget();
		Object[] args=pjp.getArgs();
		int codigo=(int)args[0];
		double cant=(double)args[1];
		if(gcajero.obtenerSaldo(codigo)>cant){
			pjp.proceed();
		}
		else{
			System.out.println("no se puede extraer");
		}
	}
	
}
