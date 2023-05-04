#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
bool contains(vector<int> vec, int x)
{
return find(vec.begin(), vec.end(), x) != vec.end();
}
int findoptimal(vector<int> ref, vector<int> blocks, int start)
{
int i, j, max;
vector<int> used(blocks.size(), 100);
for (i = 0; i < blocks.size(); i++)
{
for (j = start; j < ref.size(); j++)
{
if (ref[j] == blocks[i])
{
used[i] = j;
break;
}
}
}
auto max_it = max_element(used.begin(), used.end());
max = distance(used.begin(), max_it);
return max;
}
int main()
{
int n;
cout << "Enter the size of the string: ";
cin >> n;
int i, j, l;
vector<int> ref(n);
cout << "Enter the numbers in ref string one by one: ";
for (i = 0; i < n; i++)
{
cin >> ref[i];
}
int m;
cout << "Enter the total no of blocks available in MM: ";
cin >> m;
vector<int> blocks(m, -1);
char hitormiss = 'M';
int k = -1;
int hit = 0, miss = 0;
vector<int> used(m, -1);
for (i = 0; i < n; i++)
{
auto it = find(blocks.begin(), blocks.end(), ref[i]);
if (it != blocks.end())
{
hitormiss = 'H';
hit++;
}
else if (contains(blocks, -1))
{
hitormiss = 'M';
j = 0;
while (blocks[j] == -1)
{
j++;
}
k = j - 1;
blocks[k] = ref[i];
miss++;
}
else
{
hitormiss = 'M';
k = findoptimal(ref, blocks, i);
blocks[k] = ref[i];
miss++;
}
cout << endl;
for (j = 0; j < m; j++)
{
cout << " " << blocks[j];
}
cout << " " << hitormiss;
}
double hitratio = double(n) / hit;
double missratio = double(n) / miss;
cout << endl
<< "Hit ratio: " << hitratio;
cout << endl
<< "Miss ratio: " << missratio;
return 0;
}