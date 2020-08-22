#include<stdio.h>
int main() {

	int i, a, j, total=1;

	int buf[10];

	for(i = 0; i < 10; i++) {

		buf[i] = 0;

	}

	for(i = 0; i < 3; i++) {

		scanf("%d", &a);

		total *= a;

	}

	for(i = 0; total > 0; i++) {

		a = total % 10;

		buf[a] += 1;

		total /= 10;

	}

	for(i = 0; i < 10; i++) {

		printf("%d\n", buf[i]);

	}

}



