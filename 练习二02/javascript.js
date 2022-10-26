const pets= [
                {
                    "type": "fish",
                    "pets": [
                        {
                            "name": {
                                "first": "Nemo",
                                "last": "Finding"
                            },
                            "colours": ["orange", "white"]
                        },
                        {
                            "name": {
                                "first": "Michael",
                                "last": "Thomas"
                            },
                            "colours": ["yellow"]
                        },
                        {
                            "name": {
                                "first": "Dory",
                                "last": "Grubber"
                            },
                            "colours": ["blue", "yellow", "black"]
                        }
                    ]
                },
                {
                    "type": "cat",
                    "pets": [
                        {
                            "name": {
                                "first": "Squid",
                                "last": "Johnson"
                            },
                            "colours": ["black"]
                        },
                        {
                            "name": {
                                "first": "Peanut",
                                "last": "Day"
                            },
                            "colours": ["black", "brown"]
                        },
                        {
                            "name": {
                                "first": "Marley",
                                "last": "Day"
                            },
                            "colours": ["black", "brown"]
                        },
                        {
                            "name": {
                                "first": "Bear",
                                "last": "Blue"


                            },
                            "colours": ["gray"]
                        }
                ]
},
                {
                    "type": "dog",
                    "pets": [
                        {
                            "name": {
                                "first": "Rin",
                                "last": "Tin Tin"
                            },
                            "colours": ["black"]
                        },
                        {
                            "name": {
                                "first": "Sharik",
                                "last": "Gajos"
                            },
                            "colours": ["black", "brown"]
                        }
                    ]
                }
        ]

// const tableHeaders =
//     '<tr><th>type</th><th>name</th><th>colours</th></tr>';
//
//
// let petsHTML = '';
// petsHTML += tableHeaders;
//
//
// const petRow =
//     '<tr><td>PET_TYPE</td><td>PET_NAME</td><td>PET_COLOURS</td></tr>';
//
// function loadPetData() {
//         pets.forEach(pet => {
//         let thisPetHTML= petRow;
//         thisPetHTML = thisPetHTML.replace('PET_TYPE', pet.type);
//         pet.pets.forEach(pet1=>
//         {
//             thisPetHTML=thisPetHTML.replace('PET_NAME',pet1.name.first);
//             pet1.colours.forEach(pet2=>{thisPetHTML = thisPetHTML.replace('PET_COLOURS',pet2);});
//             petsHTML.innerHTML+= thisPetHTML;
//         });
//
//     });
//     document.getElementById("pets").innerHTML=petsHTML;
//     this line needs to be completed
// }
var table=document.getElementById('pets');
function loadPetData() {
    var tableHeaders='<tr><th>type</th><th>first_name</th><th>last_name</th><th>colours</th></tr>';
    table.innerHTML=tableHeaders;
    for(var i=0;i<pets.length;i++){
        for(var j=0;j<pets[i].pets.length;j++){
            var colours=""
            for(var k=0;k<pets[i].pets[j].colours.length;k++){
                colours+=pets[i].pets[j].colours[k];
                colours+=" ";
            }
            let thisPetHTML=tableHeaders;
            thisPetHTML=thisPetHTML.replace('type',pets[i].type);
            thisPetHTML=thisPetHTML.replace('first_name',pets[i].pets[j].name.first);
            thisPetHTML=thisPetHTML.replace('last_name',pets[i].pets[j].name.last);
            thisPetHTML=thisPetHTML.replace('colours',colours);
            table.innerHTML+=thisPetHTML;
        }
    }
}