

const abc = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
             'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
             'v', 'w', 'x', 'y', 'z']

let key = '';

$(document).ready(function(){
    $('#ci').click(function(){
        key = document.getElementById('llave').value;
        key = key.replace(/ /g,'');
        let mess = document.getElementById('mess').value;
        mess = mess.replace(/ /g, '');

        let newMess = '';
        let keyComplete = '';

        if(revision(mess, key)){
            for(var i = 0; i < mess.length; i++){
                keyComplete += key.charAt((i%Number(key.length)));
            }
            alert(keyComplete);

            for(var i = 0; i < mess.length; i++){
                let charr = mess.charAt(i);
                let posm = getPosition(charr);

                charr = keyComplete.charAt(i);
                let posk = getPosition(charr);

                let newVal = change(posm, posk);
                newMess += abc[newVal];
            }
            document.getElementById('rs').value = newMess;
        }else{

        }
    });

    $('#de').click(function(){
        key = document.getElementById('llave'),value;
        key.replace(/ /g, '');
        mess = document.getElementById('mess').value;
        mess.replace(/ /g, '');
        let newMess = "";
        let keyComplete = '';

        if(revision(mess, key)){
            for(var i=0;i<mess.length;i++){
                keyComplete += key.charAt((i%Number(key.length)));
            }
            alert(keyComplete);

            for(var i=0;i<mess.length;i++){
                let charr = mess.charAt(i);
                let posm = getPosition
            }
        }
    })

})

