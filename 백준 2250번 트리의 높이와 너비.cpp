#include <iostream>
#include <algorithm>
#define left _left
#define right _right
using namespace std;
/* 백준 센세의 코드입니당ㅠㅠㅠ 못풀겠어서  */
struct Node {
    int left, right;
    int order, depth;
};
Node a[10001];
int left[10001];
int right[10001];
int cnt[10001];
int order = 0;
void inorder(int node, int depth) {
    if (node == -1) return;
    inorder(a[node].left, depth+1);
    a[node].order = ++order;
    a[node].depth = depth;
    inorder(a[node].right, depth+1);
}
int main() {
    int n;
    cin >> n;
    for (int i=0; i<n; i++) {
        int x, y, z;
        cin >> x >> y >> z;
        a[x].left = y;
        a[x].right = z;
        if (y != -1) cnt[y] += 1;
        if (z != -1) cnt[z] += 1;
    }
    int root = 0;
    for (int i=1; i<=n; i++) {
        if (cnt[i] == 0) {
            root = i;
        }
    }
    inorder(root, 1);
    int maxdepth = 0;
    for (int i=1; i<=n; i++) {
        int depth = a[i].depth;
        int order = a[i].order;
        if (left[depth] == 0) {
            left[depth] = order;
        } else {
            left[depth] = min(left[depth], order);
        }
        right[depth] = max(right[depth], order);
        maxdepth = max(maxdepth, depth);
    }
    int ans = 0;
    int ans_level = 0;
    for (int i=1; i<=maxdepth; i++) {
        if (ans < right[i]-left[i]+1) {
            ans = right[i]-left[i]+1;
            ans_level = i;
        }
    }
    cout << ans_level << ' ' << ans;
}
