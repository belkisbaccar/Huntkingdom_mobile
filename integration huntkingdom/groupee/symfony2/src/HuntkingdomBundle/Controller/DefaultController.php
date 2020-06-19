<?php

namespace HuntkingdomBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class DefaultController extends Controller
{
    public function indexAction()
    { $em=$this->getDoctrine()->getManager();
        $Publicite=$em->getRepository("HuntkingdomBundle:Publicite")->findAll();
        foreach ($Publicite as $e)
        {
            if($e->getDateFin() < new \DateTime())
                $e->setEtat(1);
            $em->persist($e);
            $em->flush();


        }
        $Publicite1=$em->getRepository("HuntkingdomBundle:Publicite")->findAll();
        $user=$this->container->get('security.token_storage')->getToken()->getUser();
        $PubliciteAimer=$em->getRepository("HuntkingdomBundle:PubliciteAimer")->findBy(array('idUser'=>$user));

        return $this->render('@Huntkingdom/front/index.html.twig',array('Publicite'=>$Publicite1,'PubliciteA'=>$PubliciteAimer));
    }
}
