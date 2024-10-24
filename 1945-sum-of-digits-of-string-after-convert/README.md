<h2><a href="https://leetcode.com/problems/sum-of-digits-of-string-after-convert/">1945. Sum of Digits of String After Convert</a></h2><h3>Easy</h3><hr><div><p>You are given a string <code>s</code> consisting of lowercase English letters, and an integer <code>k</code>. Your task is to <em>convert</em> the string into an integer by a special process, and then <em>transform</em> it by summing its digits repeatedly <code>k</code> times. More specifically, perform the following steps:</p>

<ol>
	<li><strong>Convert</strong> <code>s</code> into an integer by replacing each letter with its position in the alphabet (i.e.&nbsp;replace <code>'a'</code> with <code>1</code>, <code>'b'</code> with <code>2</code>, ..., <code>'z'</code> with <code>26</code>).</li>
	<li><strong>T</strong><strong>ransform</strong> the integer by replacing it with the <strong>sum of its digits</strong>.</li>
	<li>Repeat the <strong>transform</strong> operation (step 2) <code>k</code><strong> times</strong> in total.</li>
</ol>

<p>For example, if <code>s = "zbax"</code> and <code>k = 2</code>, then the resulting integer would be <code>8</code> by the following operations:</p>

<ol>
	<li><strong>Convert</strong>: <code>"zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124</code></li>
	<li><strong>Transform #1</strong>: <code>262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17</code></li>
	<li><strong>Transform #2</strong>: <code>17 ➝ 1 + 7 ➝ 8</code></li>
</ol>

<p>Return the <strong>resulting</strong> <strong>integer</strong> after performing the <strong>operations</strong> described above.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "iiii", k = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">36</span></p>

<p><strong>Explanation:</strong></p>

<p>The operations are as follows:<br>
- Convert: "iiii" ➝ "(9)(9)(9)(9)" ➝ "9999" ➝ 9999<br>
- Transform #1: 9999 ➝ 9 + 9 + 9 + 9 ➝ 36<br>
Thus the resulting integer is 36.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "leetcode", k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">6</span></p>

<p><strong>Explanation:</strong></p>

<p>The operations are as follows:<br>
- Convert: "leetcode" ➝ "(12)(5)(5)(20)(3)(15)(4)(5)" ➝ "12552031545" ➝ 12552031545<br>
- Transform #1: 12552031545 ➝ 1 + 2 + 5 + 5 + 2 + 0 + 3 + 1 + 5 + 4 + 5 ➝ 33<br>
- Transform #2: 33 ➝ 3 + 3 ➝ 6<br>
Thus the resulting integer is 6.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "zbax", k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">8</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 100</code></li>
	<li><code>1 &lt;= k &lt;= 10</code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>
</div>