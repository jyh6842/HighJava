package homework.gernericEnum;

import java.text.NumberFormat;

public class GernericEnumPlanet {
	
	public enum Planet{
		수성(2439), 금성(6051), 지성(6378), 화성(3393), 목성(71492), 토성(60268), 천왕성(255559), 해왕성(24764);

		
		private double radius;
		
		Planet(double radius) { // 기본 접근 제어자가 private 이다.
			this.radius = radius;
		}
		
		public double getRadiusPlanet() {
			return radius;
		}
		
		
	}

	public static void main(String[] args) {
		
		
		
		Planet[] planetRadiusArr = Planet.values();
		for (int i = 0; i < planetRadiusArr.length; i++) {
			System.out.print(planetRadiusArr[i].name() + "의 반지름 : "+ NumberFormat.getInstance().format(Math.round(planetRadiusArr[i].getRadiusPlanet())) + "km 이고,");
			System.out.println(" 면적은 : "+ NumberFormat.getInstance().format(Math.round(planetRadiusArr[i].getRadiusPlanet()*planetRadiusArr[i].getRadiusPlanet()*3.14)) + " km^2 이다.");
			
		}

	}

}
