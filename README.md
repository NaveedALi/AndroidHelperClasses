# Oftenly used android helper,Utilities classes and methods

Calling alert
ChoiceDialog choiceDialog = (new ChoiceDialog.Builder()
                    .setTitle("Title here")
                    .setMessage("Custome message here")
                    .setStartBtnText("Exit")
                    //.setCancelable(true) // default is false
                    .setEndBtnText("Cancel") // if single button remove this line
                    .create());
            choiceDialog.setListener(listener);
            choiceDialog.show(getSupportFragmentManager(), null);
