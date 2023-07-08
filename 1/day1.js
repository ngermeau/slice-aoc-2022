import fs from 'fs'
import readline from 'readline'



// first solution for part2 
fs.readFile('input.txt', 'utf8', (err, data) => {
  let total = 0
  let max = []
  data.split(/\r?\n/).forEach(calorie => {
    if (calorie === '') {
      max.push(total)
      total = 0
    } else {
      total += +calorie
    }
  })
  max.sort((a, b) => { return a - b })
  console.log(max.slice(-3).reduce((acc, val) => acc + val))
})


// other way of doing things for for part2 
fs.readFile('input.txt', 'utf8', (err, data) => {
  let totalPerElves = data
    .split("\n\n")
    .map(elf => elf
      .split("\n")
      .map((cal) => +cal)
      .reduce((acc, cal) => acc + cal)
    )
  let sumTopThree = totalPerElves
    .sort((a, b) => a - b)
    .slice(-3)
    .reduce((acc, cal) => acc + cal)
  console.log(sumTopThree)
})






