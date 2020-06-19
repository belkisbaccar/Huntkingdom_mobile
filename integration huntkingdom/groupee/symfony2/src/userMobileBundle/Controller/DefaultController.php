<?php

namespace userMobileBundle\Controller;

use HuntkingdomBundle\Entity\Reclamation;
use HuntkingdomBundle\Entity\Reponse;
use HuntkingdomBundle\Entity\UserMobile;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use UserBundle\Entity\User;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;

class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('userMobileBundle:Default:index.html.twig');
    }
    public function findAction($id)
    {
        $tasks = $this->getDoctrine()->getManager()
            ->getRepository(User::class)
            ->findOneBy(['username' => $id]);
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($tasks);
        return new JsonResponse($formatted);
    }
    public function ajouterUserMobileAction($username,$mail,$password,$photo){
        $em=$this->getDoctrine()->getManager();
        $user= new \HuntkingdomBundle\Entity\UserMobile();
        $user->setUsername($username);
        $user->setUsernameCanonical($username);
        $user->setEmail($mail);
$user->setEmailCanonical($mail);
        $user->setEnabled(true);
        $user->setPassword($password);
        $user->setPhoto($photo);
        $roles = array("ROLE_CLIENT");
        $user->setRoles($roles);
        $em->persist($user);
        $em->flush();
       $tasks="hello";
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($tasks);
        return new JsonResponse($formatted);


    }

    public  function chercherUserMAction($username){
        $em=$this->getDoctrine()->getManager();
        $tasks="0";
        $news =$em->getRepository(UserMobile::class)->findBy(array('username'=>$username));
        if (sizeof($news)>0){

            $tasks="1";

        }
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($tasks);
        return new JsonResponse($formatted);

    }


    public function chercherUserMailAction($mail){
        $em=$this->getDoctrine()->getManager();
        $tasks="0";
        $news =$em->getRepository(UserMobile::class)->findBy(array('email'=>$mail));
        if (sizeof($news)>0){

            $tasks="1";

        }
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($tasks);
        return new JsonResponse($formatted);

    }
    public function allAction()
    {
        $listemat = $this->getDoctrine()->getManager()
            ->getRepository(Evenement::class)->findAll();

        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($listemat);
        return new JsonResponse($formatted);
    }
    public function allparticipationAction()
    {
        $listemat = $this->getDoctrine()->getManager()
            ->getRepository(Participation::class)->findAll();

        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($listemat);
        return new JsonResponse($formatted);
    }
    public function alAction()
    {
        $listemat = $this->getDoctrine()->getManager()
            ->getRepository(Evenement::class)->findAll();

        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($listemat);
        return new JsonResponse($formatted);
    }

    public function AfficheParticipationAction()
    {
        /*
                $tasks = $this->getDoctrine()->getManager()
                    ->getRepository('EventBundle:Participation')
                    ->findMyParticiaptions($this->getUser()->getUsername());
                $serializer = new Serializer([new ObjectNormalizer()]);
                $formatted = $serializer->normalize($tasks);
                return new JsonResponse($formatted);*/
        /*
        $tasks = $this->getDoctrine()->getManager()
            ->getRepository('EventBundle:Participation')
            ->findAll();
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($tasks);
        return new JsonResponse($formatted);*/
        $listemat = $this->getDoctrine()->getManager()
            ->getRepository(Participation::class)->findAll();

        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($listemat);
        return new JsonResponse($formatted);
    }
    public function ajoutereventAction(Request $request)
    {
        $Evenement= new Evenement();
        $Evenement->setTitreEvent($request->get('titreEvent'));
        $Evenement->setDescriptionEvent($request->get('descriptionEvent'));
        $image= $request->get('image');
        $Evenement->setImage($image);
        $Evenement->setDateDebutEvent(new \DateTime($request->get('dateDebutEvent')));
        $Evenement->setDateFinEvent(new \DateTime($request->get('dateFinEvent')));
        $Evenement->setNbPlaceEvent((int)$request->get('nbPlaceEvent'));
        $Evenement->setIdUserr((int)$request->get('idUserr'));
        $Evenement->setEtat(0);
        $Evenement->setNb(($Evenement->getNbPlaceEvent()));
        $em = $this->getDoctrine()->getManager();

        $em->persist($Evenement);
        $em->flush();
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($Evenement);
        return new JsonResponse($formatted);
    }
    public function modifiereventAction(Request $request){

        $em=$this->getDoctrine()->getManager();
        $Evenement=$em->getRepository(Evenement::class)->find((int)$request->get('idEvent'));
        $Evenement->setTitreEvent($request->get('titreEvent'));
        $Evenement->setDescriptionEvent($request->get('descriptionEvent'));
        $image= $request->get('image');
        $Evenement->setImage($image);
        $Evenement->setDateDebutEvent(new \DateTime($request->get('dateDebutEvent')));
        $Evenement->setDateFinEvent(new \DateTime($request->get('dateFinEvent')));
        $Evenement->setNbPlaceEvent((int)$request->get('nbPlaceEvent'));
        $Evenement->setNb(($Evenement->getNbPlaceEvent()));
        $em = $this->getDoctrine()->getManager();
        $Evenement->uploadPubimage();

        $em->persist($Evenement);
        $em->flush();


        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($Evenement);
        return new JsonResponse($formatted);
    }
    public function supprimereventAction(Request $request){

        $em=$this->getDoctrine()->getManager();
        $bus=$em->getRepository(Evenement::class)->find((int)$request->get('idEvent'));
        $em->remove($bus);
        $em->flush();


        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($bus);
        return new JsonResponse($formatted);
    }
    public function ajouterparticipationAction(Request $request,$id)
    {

        $participation= new Participation();
        $em = $this->getDoctrine()->getManager();
        $participation->setUsername($request->get('username'));
        $participation->setDateReservation(new \DateTime($request->get('dateReservation')));
        $event=$em->getRepository(Evenement::class)->find($id);
        $participation->setIdEvent($event);


        $event->setNbPlaceEvent(($event->getNbPlaceEvent())-1);
        $em->persist($participation);
        $em->flush();
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($participation);
        return new JsonResponse($formatted);
    }
    public function supprimerParticipationAction(Request $request,$id){

        $em=$this->getDoctrine()->getManager();
        $bus=$em->getRepository(Participation::class)->find((int)$request->get('idParticipation'));
        $event=$em->getRepository(Evenement::class)->find($id);
        $event->setNbPlaceEvent(($event->getNbPlaceEvent())+1);
        $em->remove($bus);
        $em->flush();


        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($bus);
        return new JsonResponse($formatted);
    }
}
