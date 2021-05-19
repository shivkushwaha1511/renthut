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
    let help = document.querySelector("#help_"+field.name);
    let err = document.querySelector("#err_"+field.name);

    if(pattern.test(field.value)){
        field.classList.replace("fail","success");
        result[field.name] = true;
        help.classList.replace("hide","show");
        err.classList.replace("show","hide");
    }
    else{
        if(field.classList.contains("success")){
                field.classList.replace("success","fail");
                help.classList.replace("show","hide");
                err.classList.replace("hide","show");
        }
        else{
            field.classList.add("fail");
            help.classList.add("hide");
            err.classList.replace("hide","show");
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

    input.addEventListener("blur",function(event){
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