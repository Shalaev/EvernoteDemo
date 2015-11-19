/**
 * Created by Сергей on 15.11.2015.
 */
$( document ).ready(function() {
    Evernote.init($('#action'),$('#shortMode'), $('#noteForm'));
});
/**
 * Object to work with the application form.
 * @type {{init, submitForm, submitShortForm}}
 */
var Evernote = (function(){
    var actionNode, formNode, shortNode;

    return {
        /**
         * Method object initialization.
         * @param action modifier action form (input)
         * @param short modifier the sort notes (input)
         * @param form node application forms.
         */
        init: function(action, short, form){
            actionNode = action;
            formNode = form;
            shortNode = short;
        },
        /**
         * The handler for send the form to server.
         * @param submitNode node control
         */
        submitForm: function(submitNode){
            $(actionNode).val($(submitNode).val());
            $(formNode).submit();
        },
        /**
         * Processor change the display mode list of notes.
         * @param submitShortNode node control
         */
        submitShortForm: function(submitShortNode){
            $(shortNode).val($(submitShortNode).val());
            $(actionNode).val("Short");
            $(formNode).submit();
        }
    }
}());


Function.prototype.method = function(name, func) {
    if(!this.prototype[name]){
        this.prototype[name] = func;
        return this;
    }
};