import fs from 'fs'
import readline from 'readline'


let strategy =
{
  x: {
    val: 0,
    a: 3,
    b: 1,
    c: 2
  },
  y: {
    val: 3,
    a: 1,
    b: 2,
    c: 3
  },
  z: {
    val: 6,
    a: 2,
    b: 3,
    c: 1
  }
}

fs.readFile('input.txt', 'utf8', (err, data) => {
  let result = data.split("\n")
    .slice(0, -1)
    .map((round) => round.replace(" ", "").toLowerCase().trim())
    .reduce((acc, round) => acc + strategy[round[1]]["val"] + (strategy[round[1]][round[0]]), 0)
  console.log(result)
})



