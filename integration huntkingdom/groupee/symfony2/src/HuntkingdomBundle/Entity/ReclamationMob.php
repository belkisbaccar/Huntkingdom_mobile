<?php

namespace HuntkingdomBundle\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;
/**
 * Reclamation
 *
 * @ORM\Table(name="reclamation", indexes={@ORM\Index(name="id_produit", columns={"id_produit"}), @ORM\Index(name="id_annonce_reclame", columns={"id_annonce_reclame"}), @ORM\Index(name="id_user", columns={"id_user"})})
 * @ORM\Entity
 */
class ReclamationMob
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_reclamation", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idReclamation;

    /**
     * @var string
     *
     * @ORM\Column(name="etat", type="string", length=25, nullable=false)
     */
    private $etat;

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="string", length=255, nullable=false)
     */
    private $description;

    /**
     * @var string
     *
     * @ORM\Column(name="image", type="string", length=255, nullable=true)
     */
    private $image = 'NULL';

    /**
     * @var integer
     *
     * @ORM\Column(name="note", type="integer", nullable=false)
     */
    private $note;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date", type="date", nullable=false)
     */
    private $date = 'current_timestamp()';

    /**
     * @var \HuntkingdomBundle\Entity\Annonce
     *
     * @ORM\ManyToOne(targetEntity="HuntkingdomBundle\Entity\Annonce")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_annonce_reclame", referencedColumnName="id_annonce")
     * })
     */
    private $idAnnonceReclame;

    /**
     * @var \HuntkingdomBundle\Entity\Product
     *
     * @ORM\ManyToOne(targetEntity="HuntkingdomBundle\Entity\Product")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_produit", referencedColumnName="ID")
     * })
     */
    private $idProduit;


    /**
     * @var integer
     *
     * @ORM\Column(name="priority", type="integer", nullable=false)
     */
    private $priority;
    /**
     * @return int
     */
    public function getIdReclamation(): int
    {
        return $this->idReclamation;
    }

    /**
     * @param int $idReclamation
     */
    public function setIdReclamation(int $idReclamation)
    {
        $this->idReclamation = $idReclamation;
    }

    /**
     * @return string
     */
    public function getEtat(): string
    {
        return $this->etat;
    }

    /**
     * @param string $etat
     */
    public function setEtat(string $etat)
    {
        $this->etat = $etat;
    }

    /**
     * @return string
     */
    public function getDescription()
    {
        return $this->description;
    }

    /**
     * @param string $description
     */
    public function setDescription(string $description)
    {
        $this->description = $description;
    }

    /**
     * @return string
     */
    public function getImage(): string
    {
        return $this->image;
    }

    /**
     * @param string $image
     */
    public function setImage(string $image)
    {
        $this->image = $image;
    }

    /**
     * @return int
     */
    public function getNote(): int
    {
        return $this->note;
    }

    /**
     * @param int $note
     */
    public function setNote(int $note)
    {
        $this->note = $note;
    }

    /**
     * @return \DateTime
     */
    public function getDate(): \DateTime
    {
        return $this->date;
    }

    /**
     * @param \DateTime $date
     */
    public function setDate(\DateTime $date)
    {
        $this->date = $date;
    }

    /**
     * @return Annonce
     */
    public function getIdAnnonceReclame()
    {
        return $this->idAnnonceReclame;
    }

    /**
     * @param Annonce $idAnnonceReclame
     */
    public function setIdAnnonceReclame(Annonce $idAnnonceReclame)
    {
        $this->idAnnonceReclame = $idAnnonceReclame;
    }

    /**
     * @return Product
     */
    public function getIdProduit()
    {
        return $this->idProduit;
    }

    /**
     * @param Product $idProduit
     */
    public function setIdProduit(Product $idProduit)
    {
        $this->idProduit = $idProduit;
    }

    /**
     * @return User
     */
    public function getIdUser()
    {
        return $this->idUser;
    }

    /**
     * @param User $idUser
     */
    public function setIdUser(User $idUser)
    {
        $this->idUser = $idUser;
    }



    /**
     * @var \HuntkingdomBundle\Entity\User
     *
     * @ORM\ManyToOne(targetEntity="HuntkingdomBundle\Entity\User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_user", referencedColumnName="id")
     * })
     */
    private $idUser;




    /**
     * @return int
     */
    public function getPriority()
    {
        return $this->priority;
    }

    /**
     * @param int $priority
     */
    public function setPriority(int $priority)
    {
        $this->priority = $priority;
    }



}

