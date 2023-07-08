import fs from "fs";

function solve1(pairs) {
  let count = 0;
  pairs.forEach((pair) => {
    let [s1, s2, s3, s4] = [...pair[0].split("-"), ...pair[1].split("-")].map(
      (val) => +val
    );
    if ((s1 >= s3 && s2 <= s4) || (s3 >= s1 && s4 <= s2)) {
      count += 1;
    }
  });
  return count;
}

function solve2(pairs) {
  let count = 0;

  pairs.forEach((pair) => {
    let [s1, s2, s3, s4] = [...pair[0].split("-"), ...pair[1].split("-")].map(
      (val) => +val
    );
    if (!(s3 > s2 || s1 > s4)) {
      count += 1;
    }
  });
  return count;
}

fs.readFile("input.txt", "utf8", (err, data) => {
  let pairs = data.split("\n").map(pair => pair.split(",")).slice(0, -1)
  console.log(solve2(pairs));
});
