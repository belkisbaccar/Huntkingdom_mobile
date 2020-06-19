<?php

namespace HuntkingdomBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Reponse
 *
 * @ORM\Table(name="reponse", indexes={@ORM\Index(name="id_reclamation", columns={"id_reclamation"})})
 * @ORM\Entity
 */
class RepMob
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_reponse", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idReponse;

    /**
     * @var string
     *
     * @ORM\Column(name="contenu", type="string", length=255, nullable=false)
     */
    private $contenu;

    /**
     * @var string
     *
     * @ORM\Column(name="image", type="string", length=255, nullable=false)
     */
    private $image;

    /**
     * @var \HuntkingdomBundle\Entity\ReclamationMob
     *
     * @ORM\ManyToOne(targetEntity="HuntkingdomBundle\Entity\ReclamationMob")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_reclamation", referencedColumnName="id_reclamation")
     * })
     */
    private $idReclamation;
    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date", type="date", nullable=false)
     */
    private $date = 'current_timestamp()';
    /**
     * @return int
     */
    public function getIdReponse(): int
    {
        return $this->idReponse;
    }


    /**
     * @return string
     */
    public function getContenu()
    {
        return $this->contenu;
    }



    /**
     * @return string
     */
    public function getImage()
    {
        return $this->image;
    }



    /**
     * @return Reclamation
     */
    public function getIdReclamation()
    {
        return $this->idReclamation;
    }



    /**
     * @return \DateTime
     */
    public function getDate()
    {
        return $this->date;
    }

}

