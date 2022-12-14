#include<iostream>

typedef struct t_Animal
{
	char name[30];
	int age;
	int health;
	int food;
	int clean;
}Animal;

void create_animal(Animal* animal) {
	std::cout << "동물의 이름 : ";
	std::cin >> animal->name;

	std::cout << "동물의 나이 : ";
	std::cin >> animal->age;

	animal->health = 100;
	animal->food = 100;
	animal->clean = 100;
}
void play(Animal* animal) {
	animal->health += 10;
	animal->food -= 20;
	animal->clean -= 30;
}
void one_day_pass(Animal* animal) {
	animal->health -= 10;
	animal -> food -= 30;
	animal->clean -= 20;
}
void show_stat(Animal* animal) {
	std::cout << "Health : " << animal->health << std::endl;
	std::cout << "food : " << animal->food << std::endl;
	std::cout << "clean : " << animal->clean << std::endl;
}
int main()
{
	Animal* list[10];
	int animal_num = 0;
	for (;;) {
		std::cout << "1. 동물 추가 " << std::endl;
		std::cout << "2. 놀기 " << std::endl;
		std::cout << "3. 상태 보기" << std::endl;

		int input;
		int play_with;
		std::cin >> input;
		switch (input)
		{
		case 1:
			list[animal_num] = new Animal;
			create_animal(list[animal_num]);

			animal_num++;
			break;
		case 2:
			std::cout << "누구랑 놀게 : ";
			std::cin >> play_with;
			if (play_with < animal_num) play(list[play_with]);
			break;
		case 3:
			std::cout << "누구 스탯 :";
			std::cin >> play_with;
			if (play_with < animal_num) show_stat(list[play_with]);

			break;
		}
		for (int i = 0; i != animal_num; i++)
			one_day_pass(list[i]);
	}
	for (int i = 0; i != animal_num; i++)
		delete list[i];

}