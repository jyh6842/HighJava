package test.singletontest;

import java.util.List;
import java.util.Scanner;


public class ProdController {

	private ProdService service;

	private static ProdController controller;

	private ProdController() {
		service = ProdService.getInstance();
	}

	public static ProdController getInstance() {
		if (controller == null) {
			controller = new ProdController();
		}
		return controller;
	}

	public void prodList() {
		List<ProdVO> prodList = service.prodList();

		for (int i = 0; i < prodList.size(); i++) {
			ProdVO pVO = prodList.get(i);
			System.out.println(pVO.getProd_id());
			System.out.println(pVO.getProd_name());
			System.out.println(pVO.getProd_lgu());
			System.out.println(pVO.getProd_cost());
			System.out.println(pVO.getProd_buyer());
			
		}

		// 향상된 for문
		for (ProdVO pVO : prodList) {
			pVO.getProd_id();
			pVO.getProd_name();
			pVO.getProd_lgu();
			pVO.getProd_cost();
			pVO.getProd_buyer();
			System.out.println(pVO);
		}
	}

	public void prodInfo(String id) {
		ProdVO pVO = service.prodInfo(id);
		System.out.println(pVO);
		System.out.println("prodInfo(String id)가 출력되었습니다.");

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ProdController pc = ProdController.getInstance();

		while (true) {
			System.out.println("번호를 선택해주세요  1 ~ 3 >>");
			int input = Integer.parseInt(s.nextLine());

			switch (input) {
			case 1:
				pc.prodList();
				break;
			case 2:
				String id = s.nextLine();
				System.out.print("아이디를 입력해주세요 >> ");
				pc.prodInfo(id);
				break;
			case 3:
				System.out.println("종료되었습니다.");
				break;

			}

			if (input == 3) {
				break;
			}

		}

	}

}
