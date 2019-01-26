#include <stdio.h>

int main() {

	char str[1000000];

	int count = 0;

	int i;
	int isSpace = 1;

	scanf("%[^\n]s", str);

	for (i = 0; str[i]; i++) {
		if (str[i] == ' ') isSpace = 1;

		else if(isSpace) {
			isSpace = 0;
			count++;
		}
	}

	printf("%d", count);

	return 0;

}
