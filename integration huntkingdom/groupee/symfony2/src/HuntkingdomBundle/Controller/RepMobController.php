<?php

namespace HuntkingdomBundle\Controller;

use HuntkingdomBundle\Entity\ReclamationMob;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;
use Symfony\Component\Validator\Constraints\Date;
use Symfony\Component\Validator\Constraints\DateTime;
use Symfony\Component\Validator\Tests\Fixtures\ToString;

class RepMobController extends Controller
{
    public function allAction($iduser){
        $reclamations = $this->getDoctrine()->getManager()
            ->getRepository('HuntkingdomBundle:ReclamationMob')
            ->findBy(array("idUser"=>$iduser));
        $reponse=array();


        foreach ($reclamations as $value) {

            $reponses = $this->getDoctrine()->getRepository('HuntkingdomBundle:RepMob')->findBy(array('idReclamation' => $value->getIdReclamation()));
            $reponse = array_merge($reponse, $reponses);
        }

        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($reponse);
        return new JsonResponse($formatted);
    }

    public function recrepAction($idreponse){
        $reponse = $this->getDoctrine()->getManager()
            ->getRepository('HuntkingdomBundle:RepMob')
            ->find($idreponse);
        //$reclamation = new ReclamationMob();

        $reclamation= $reponse->getIdReclamation();
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($reclamation);
        return new JsonResponse($formatted);
    }
    /*public function recrep($iduser,$idrep){
        $reclamations = $this->getDoctrine()->getManager()
            ->getRepository('HuntkingdomBundle:ReclamationMob')
            ->findBy(array("idUser"=>$iduser));
        $reponse=array();

        //$id =0;
        foreach ($reclamations as $value) {

            $reponses = $this->getDoctrine()->getRepository('HuntkingdomBundle:RepMob')->findBy(array('idReclamation' => $value->getIdReclamation()));
            // $id=$reponses->getIdReclamation();

            $reponse = array_merge($reponse, $reponses);
        }
        foreach ($reponse as $r){
           $id= $r->getIdReclamation()->getIdReclamation();
        }
        print $id;
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($id);
        return new JsonResponse($formatted);
    }*/

    public function newrAction($iduser){
        $new=0;
        $reclamations = $this->getDoctrine()->getManager()
            ->getRepository('HuntkingdomBundle:ReclamationMob')
            ->findBy(array("idUser"=>$iduser));
        $reponse=array();

        $d= new \DateTime();


        foreach ($reclamations as $value) {

            $reponses = $this->getDoctrine()->getRepository('HuntkingdomBundle:RepMob')->findBy(array('idReclamation' => $value->getIdReclamation()));


            $reponse = array_merge($reponse, $reponses);


        }
        $n =array();
        foreach ($reponse as $r) {

            $ra=array($r);
            //$ra=$r;
            $difference = $d->diff($r->getDate())->days;
            if ($difference == 0) {
                $n=array_merge($n,$ra);

            }
        }
        /* foreach ($reponse as $r){

             $difference=$d->diff($r->getDate())->days;
             if( $difference ==0){
                 $new++;

             }
         }*/
//print ($n);
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($n);
        return new JsonResponse($formatted);
    }
}
