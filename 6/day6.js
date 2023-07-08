import fs from "fs";


function solve(stream, messageSize) {
  for (let i = messageSize - 1; i <= stream.length; i++) {
    let message = stream.slice(i - (messageSize - 1), i + 1)
    let dupl = message.filter((val, index) => index != message.indexOf(val))
    if (dupl.length === 0) {
      return (i + 1)
    }
  }
}

fs.readFile("input.txt", "utf8", (err, data) => {
  let stream = data.split("").slice(0, -1);
  console.log(solve(stream, 4))
  console.log(solve(stream, 14))
});
