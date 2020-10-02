/*

*/
#include <bits/stdc++.h>
#define mod 1000000007
#define inf 1000000000000000000
#define mk make_pair
#define pb push_back
#define pii pair<lli, lli>
#define fastio ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
using namespace std;
typedef unsigned long long ull;
typedef long long int lli;
typedef long double ld;
const lli sz = 100010, sz2 = 1000010;
lli toint(const string &s) {stringstream ss; ss << s; lli x; ss >> x; return x;}
string tostring ( lli number ) {stringstream ss; ss << number; return ss.str();}
void io ()
{
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif
}
lli power (lli a, lli b)
{
	if (b == 0) {
		return 1;
	}
	if (b == 1) {
		return a % mod;
	}
	lli ans = power(a, b / 2);
	ans = (ans * ans) % mod;
	if (b & 1) {
		ans = (ans * a) % mod;
	}
	return ans;
}
lli lcm (lli a, lli b)
{
	return (a / __gcd(a, b)) * b;
}
int main ()
{
	io();
	int n;
	cin >> n;
	vector<lli> a(n);
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	vector<lli> pre(n), suf(n);
	for (int i = 0; i < n; i++) {
		pre[i] = a[i];
		if (i > 0) {
			pre[i] = __gcd(pre[i], pre[i - 1]);
		}
	}
	for (int i = n - 1; i >= 0; i--) {
		suf[i] = a[i];
		if (i < n - 1) {
			suf[i] = __gcd(suf[i], suf[i + 1]);
		}
	}
	lli ans;
	for (int i = 0; i < n; i++) {
		if (i == 0) {
			ans = suf[i + 1];
		}
		else if (i == n - 1) {
			ans = lcm(ans, pre[i - 1]);
		}
		else {
			ans = lcm(ans, __gcd(pre[i - 1], suf[i + 1]));
		}
	}
	cout << ans << endl;
	return 0;
}
