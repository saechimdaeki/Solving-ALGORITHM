/*2720번 수 정렬하기*/

#include<stdio.h>

int main() {





	int i, arr[1000] = {0,}, n, temp, j;



	scanf("%d", &n);



	for (i = 0; i < n; i++) {



		scanf("%d", &arr[i]);

	}



	for (i = 0; i < n; i++) {

		for (j = 0; j < n; j++) {



			if (arr[j] > arr[i]) {



				temp = arr[j];

				arr[j] = arr[i];

				arr[i] = temp;

			}

		}

	}



	for (i = 0; i < n; i++) {



		printf("%d\n", arr[i]);

	}

}

