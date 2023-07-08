import fs from 'fs'
import readline from 'readline'

let toPoints = (character) => {
    return (character.toUpperCase() === character)
        ? character[0].charCodeAt(0) - 38
        : character[0].charCodeAt(0) - 96
}

// part1 
let part1 = () => {
    fs.readFile('input.txt', 'utf8', (err, data) => {

        let points = 0

        data.split("\n").slice(0, -1).forEach(ruck => {
            let itemsSetA = [...new Set(ruck.slice(0, ruck.length / 2).split(''))]
            let itemsSetB = [...new Set(ruck.slice(ruck.length / 2).split(''))]
            let singleItems = [...itemsSetA, ...itemsSetB]
            let error = singleItems.filter((item, index) => singleItems.indexOf(item) != index)

            points += toPoints(error[0])

        })
        console.log(points)
    })
}


// part2 
fs.readFile('input.txt', 'utf8', (err, data) => {

    let points = 0

    let groups = data.split("\n").slice(0, -1).map((elem, index, arr) => {
        if (index % 3 === 0) {
            return [elem, arr[index + 1], arr[index + 2]]
        }
    }).filter(elem => elem != undefined)

    groups.forEach(bags => {
        let elve1 = [...new Set(bags[0].split(''))]
        let elve2 = [...new Set(bags[1].split(''))]
        let elve3 = [...new Set(bags[2].split(''))]
        let total = [...elve1, ...elve2, ...elve3]
        let badge = total.sort().filter((item, index) => {
            return (item === total[index + 1] && item === total[index + 2])
        })
        points += toPoints(badge[0])
    })

    console.log(points)

})
