<?php


namespace HuntkingdomBundle\Controller;


use EventBundle\Entity\Evenement;
use HuntkingdomBundle\Entity\Chasse;
use HuntkingdomBundle\Entity\newsletter;
use HuntkingdomBundle\Entity\Promotion;
use HuntkingdomBundle\Entity\Publicite;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;

class newsletterController extends Controller

{
    public function ajoutNewsAction($id_user,$etat,$mail){
        $em=$this->getDoctrine()->getManager();
        $newsletter= new newsletter();
        $newsletter->setMail($mail);
        $newsletter->setEtat($etat);
        $newsletter->setIdUser($id_user);
        $em->persist($newsletter);
        $em->flush();
        $tasks="hello";
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($tasks);
        return new JsonResponse($formatted);

    }
    public  function cherchernewsAction($id_user){
        $em=$this->getDoctrine()->getManager();
        $tasks="0";
        $news =$em->getRepository(newsletter::class)->findBy(array('id_user'=>$id_user));
        if (sizeof($news)>0){

            $tasks="1";

        }
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($tasks);
        return new JsonResponse($formatted);

    }
    public  function getnewsAction($id_user){
        $em=$this->getDoctrine()->getManager();
        $news =$em->getRepository(newsletter::class)->findBy(array('id_user'=>$id_user));
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($news);
        return new JsonResponse($formatted);

    }
  public function updateAction($id,$etat,$mail){
      $em=$this->getDoctrine()->getManager();
      $news=$em->getRepository(newsletter::class)->find($id);
      $news->setEtat($etat);
      $news->setMail($mail);
      $em->flush();
      $tasks="valide";
      $serializer = new Serializer([new ObjectNormalizer()]);
      $formatted = $serializer->normalize($tasks);
      return new JsonResponse($formatted);

  }
  public  function promocountAction(){
      $em = $this->getDoctrine()->getManager();
      $Publicite = $em->getRepository(Promotion::class)->findBy(array('dateDebut'=> new \DateTime()));
      $tasks=sizeof($Publicite);
      $serializer = new Serializer([new ObjectNormalizer()]);
      $formatted = $serializer->normalize($tasks);
      return new JsonResponse($formatted);


  }
    public  function eventcountAction(){
        $em = $this->getDoctrine()->getManager();
        $Publicite = $em->getRepository(Evenement::class)->findBy(array('dateDebutEvent'=> new \DateTime()));
        $tasks=sizeof($Publicite);
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($tasks);
        return new JsonResponse($formatted);


    }
    public  function chassecountAction(){
        $em = $this->getDoctrine()->getManager();
        $Publicite = $em->getRepository(Chasse::class)->findBy(array('dateDebut'=> new \DateTime()));
        $tasks=sizeof($Publicite);
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($tasks);
        return new JsonResponse($formatted);


    }
    public  function countAllAction(){
        $em = $this->getDoctrine()->getManager();
        $Publicite = $em->getRepository(Chasse::class)->findBy(array('dateDebut'=> new \DateTime()));
        $Publicite1 = $em->getRepository(Evenement::class)->findBy(array('dateDebutEvent'=> new \DateTime()));
        $Publicite2 = $em->getRepository(Promotion::class)->findBy(array('dateDebut'=> new \DateTime()));
        $tasks=sizeof($Publicite)+sizeof($Publicite1)+sizeof($Publicite2);
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($tasks);
        return new JsonResponse($formatted);


    }
    public function getPromotodayAction(){
        $em = $this->getDoctrine()->getManager();
        $Publicite2 = $em->getRepository(Promotion::class)->findBy(array('dateDebut'=> new \DateTime()));
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($Publicite2);
        return new JsonResponse($formatted);


    }
    public function getEventtodayAction(){
        $em = $this->getDoctrine()->getManager();
        $Publicite1 = $em->getRepository(Evenement::class)->findBy(array('dateDebutEvent'=> new \DateTime()));
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($Publicite1);
        return new JsonResponse($formatted);


    }
    public function getChassetodayAction(){
        $em = $this->getDoctrine()->getManager();
        $Publicite = $em->getRepository(Chasse::class)->findBy(array('dateDebut'=> new \DateTime()));
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($Publicite);
        return new JsonResponse($formatted);


    }

    public function sendMailNAction($username,$mail){

        $mailer= $this->get('mailer');
        $msg = (new \Swift_Message('Inscription newsletter'))
            ->setFrom("belkisbaccar29@gmail.com")
            ->setTo($mail)
            ->setBody($this->renderView('@Mail/Mail/mailNews.html.twig',['username'=>$username]),'text/html');
        $mailer->send($msg);
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($mailer);
        return new JsonResponse($formatted);
    }
}