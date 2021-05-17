const inputs = document.querySelectorAll("input");
const form = document.forms[0];

const Patterns = {
    name : /^[A-z a-z]{3,50}$/,
    email : /^([A-Za-z][A-Za-z\d-_]*)@([A-Za-z]{2,})\.([A-Za-z]{2,5})(\.[A-Za-z]{2,5})?$/,
    password : /^[A-Za-z\d@_-]{8,20}$/
};

const result = {
    name : false,
    email: false,
    password: false
};

const validate = function(pattern,field){
    if(pattern.test(field.value)){
        field.classList.replace("fail","success");
        result[field.name] = true;
    }
    else{
        if(field.classList.contains("success"))
            field.classList.replace("success","fail");
        else{
            field.classList.add("fail");
        }

        result[field.name] = false;
    }
};

inputs.forEach(function(input){
    input.addEventListener("keyup",function(event){
         let pattern = Patterns[event.target.name];
         let field = event.target;
         validate(pattern,field);
    });

    input.addEventListener("click",function(event){
         let pattern = Patterns[event.target.name];
         let field = event.target;
         validate(pattern,field);
    });
});


form.addEventListener("submit",function(event){
    if(result.name && result.email && result.password){
        return true;
    }else{
        event.preventDefault();
        return false;
    }
});