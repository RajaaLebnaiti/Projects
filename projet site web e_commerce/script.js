const bar=document.getElementById('bar');
const close=document.getElementById('close');
const nav=document.getElementById('navbar');

if(bar){
    bar.assEventListener('click',()=>{
        nav.classList.add('active');
    })
}

if(close){
    close.assEventListener('click',()=>{
        nav.classList.remove('active');
    })
}

  