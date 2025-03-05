package chapter16.practice.service;

import java.util.ArrayList;
import java.util.List;

import chapter16.practice.entity.Book;
import chapter16.practice.entity.Category;
import chapter16.practice.entity.Item;

public class LibraryManager implements Manageable {
	// 데이터 저장소(repository 역할)
	private List<Item> items = new ArrayList<Item>();
	
	public LibraryManager() {
		items.add(new Book("1", "자바", "책1", "문창배", "코리아", Category.FANTASY));
		items.add(new Book("12", "자바", "책12", "문창배", "코리아", Category.FICTION));
		items.add(new Book("13", "자바", "책13", "문창배", "코리아", Category.HISTORY));
		items.add(new Book("14", "자바", "책14", "문창배", "코리아", Category.NONFICTION));
		items.add(new Book("15", "자바", "책15", "문창배", "코리아", Category.SCIENCE));
		items.add(new Book("16", "자바", "책16", "문창배", "코리아", Category.FANTASY));
		items.add(new Book("17", "자바", "책17", "문창배", "코리아", Category.SCIENCE));
		items.add(new Book("18", "자바", "책18", "문창배", "코리아", Category.HISTORY));
		items.add(new Book("19", "자바", "책19", "문창배", "코리아", Category.HISTORY));
	}
	
	@Override
	public List<Item> searchByCategory(Category category) {
		List<Item> result = new ArrayList<Item>();
	
		for (Item item : items) {
			// 다운 캐스팅이 가능한지 확인
			if (item instanceof Book && ((Book) item).getCategory() == category) {
				// 검색하고자 하는 카테고리와 일치하면
				result.add(item);
			}
		}

		return result;
	}
	
}
