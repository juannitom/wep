/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  natha
 * Created: 28 déc. 2017
 */
use Weplay;

db.createCollection("notification");

db.notification.insert({
    _id:"NOT_1",
    idUser:"UTL_1",
    idAction:"ACT_1",
    idPub:"PUB_1",
    daty:"10/12/12"
});

db.createCollection("actions");

db.actions.insert({
    _id:"ACT_1",
    actions:"aimer"
});
db.actions.insert({
    _id:"ACT_2",
    actions:"commenter"
});
db.actions.insert({
    _id:"ACT_3",
    actions:"partager"
});

db.createCollection("Utilisateur");

db.utilisateur.insert({
    _id:"UTL_1",
    nom:"Tahiry Mihanta",
    email:"tahirymihanta@gmail.com",
    mdp:"mimi",
    sexe:"feminin",
    emploi:"etudiante",
    photo:"mihanta.jpg",
    score:"0"
});

db.utilisateur.insert({
    _id:"UTL_2",
    nom:"Nathalie Bienvenue",
    email:"nathaliebienvenue@gmail.com",
    mdp:"nata",
    sexe:"feminin",
    emploi:"etudiante",
    photo:"nathalie.jpg",
    score:"0"
});

db.createCollection("publication");

db.publication.insert({
    _id:"PUB_1",
    idUser:"UTL_1",
    description:"je joue Weplay tous le jours",
    photo:"weplay.jpg",
    daty:"01/02/2018",
    valide:"0"
});

db.publication.insert({
    _id:"PUB_2",
    idUser:"UTL_1",
    description:"Cool",
    photo:"weplay.jpg",
    daty:"01/02/2018",
    valide:"1"
});

db.createCollection("commentaire");

db.commentaire.insert({
    _id:"COM_1",
    idUser:"UTL_1",
    idPub:"PUB_1",
    commentaire:"tiko be"
});
db.commentaire.insert({
    _id:"COM_2",
    idUser:"UTL_1",
    idPub:"PUB_1",
    commentaire:"milay ka"
});

db.createCollection("jaime");

db.jaime.insert({
    _id:"JM_1",
    idUser:"UTL_1",
    idPub:"PUB_1"
});
db.jaime.insert({
    _id:"JM_2",
    idUser:"UTL_2",
    idPub:"PUB_1"
});

db.createCollection("partage");

db.partage.insert({
    _id:"PRTG_1",
    idUser:"UTL_1",
    idPub:"PUB_1"
});



db.createCollection("message");

db.message.insert({
_id:"MSG_1",
destinateur:"UTL_1",
 expediteur:"UTL_2",
 message:"Hello",
daty:"20/03/2018 12:03:23"
});
db.createCollection("userConnecte");

db.userConnecte.insert({
_id:"UC_1",
idUser:"UTL_1"
});

db.createCollection('coordonnees');
db.coordonnees.insert({
   _id:"coord_1",
   idmatchs:"matchs_1",
   idUser:"UTL_1",
   x:"1",
   y:"1",
   types:"Chili",
   point:"1"
});
db.coordonnees.insert({
   _id:"coord_2",
   idmatchs:"matchs_1",
   idUser:"UTL_2",
   x:"5",
   y:"5",
   types:"Lays",
   point:"0"
});
db.coordonnees.insert({
   _id:"coord_3",
   idmatchs:"matchs_1",
   idUser:"UTL_1",
   x:"4",
   y:"5",
   types:"Chili",
   point:"1"
});
db.coordonnees.insert({
   _id:"coord_4",
   idmatchs:"matchs_1",
   idUser:"UTL_2",
   x:"3",
   y:"5",
   types:"Lays",
   point:"0"
});
db.coordonnees.insert({
   _id:"coord_5",
   idmatchs:"matchs_1",
   idUser:"UTL_1",
   x:"4",
   y:"4",
   types:"Chili",
   point:"0"
});
db.coordonnees.insert({
   _id:"coord_6",
   idmatchs:"matchs_1",
   idUser:"UTL_2",
   x:"4",
   y:"4",
   types:"Lays",
   point:"1"
});
db.createCollection('matchs');
db.matchs.insert({
    _id:"matchs_1",
    idUser1:"UTL_1",
    idUser2:"UTL_2",
    datematch:"01/01/2018",
    etat:"0"
});
db.matchs.insert({
    _id:"matchs_2",
    idUser1:"UTL_2",
    idUser2:"UTL_1",
    datematch:"01/01/2018",
    etat:"0"
});
db.createCollection('demande');
db.demande.insert({
    _id:"demande_1",
    iddemandeur:"UTL_1",
    iddemande:"UTL_2",
});
db.demande.insert({
    _id:"demande_2",
    iddemandeur:"UTL_1",
    iddemande:"UTL_2",
});
db.createCollection('resultats');
db.resultats.insert({
    _id:"resultats_1",
    idmatchs:"matchs_1",
    resultat1:"2",
    resultat2:"1"
});
